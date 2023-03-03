package com.example.arrosit.Camera

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.appcompat.app.AppCompatDelegate
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.content.ContextCompat
import com.example.arrosit.R
import com.example.arrosit.databinding.FragmentCameraBinding


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class CameraFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding: FragmentCameraBinding
    var animator: ObjectAnimator? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        binding = FragmentCameraBinding.inflate(layoutInflater)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CameraFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onStart() {
        startCamera()
        super.onStart()
    }

    override fun onResume() {

        val viewTreeObserver = binding.scannerLayout.viewTreeObserver

        viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener{
            override fun onGlobalLayout() {
                binding.scannerLayout.viewTreeObserver.removeOnGlobalLayoutListener(this)

                animator = ObjectAnimator.ofFloat(
                    binding.scannerBar, "translationY",
                    binding.scannerLayout.y-20,
                    (binding.scannerLayout.y +
                            binding.scannerLayout.height))

                animator!!.repeatMode = ValueAnimator.REVERSE
                animator!!.repeatCount = ValueAnimator.INFINITE
                animator!!.interpolator = AccelerateDecelerateInterpolator()
                animator!!.duration = 3000
                animator!!.start()
            }
        })

        startCamera()
        super.onResume()
    }

    private fun startCamera() {
        val cameraProviderFuture = ProcessCameraProvider.getInstance(requireContext())

        cameraProviderFuture.addListener({
            val cameraProvider = cameraProviderFuture.get()

            val preview = Preview.Builder()
                .build()
                .also {
                    it.setSurfaceProvider(binding.previewView.surfaceProvider)
                }

            val imageAnalyzer = ImageAnalysis.Builder()
                .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
                .build()


            val cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA

            try {
                cameraProvider.unbindAll()
                cameraProvider.bindToLifecycle(this, cameraSelector, preview, imageAnalyzer)
            } catch (exc: Exception) {
                exc.printStackTrace()
            }
        }, ContextCompat.getMainExecutor(requireContext()))
    }
}