package com.example.viewmodel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.viewmodel.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private val clickerViewModel : ClickerViewModel by activityViewModels<ClickerViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)

        with(binding){
            clickerViewModel.hedgehogScoreLiveData.observe(viewLifecycleOwner){
                textviewHedgehogScore.text = clickerViewModel.hedgehogScoreLiveData.value.toString()
            }

            clickerViewModel.shrimpScoreLiveData.observe(viewLifecycleOwner){
                textviewShrimpScore.text = clickerViewModel.shrimpScoreLiveData.value.toString()
            }

            clickerViewModel.jellyfishScoreLiveData.observe(viewLifecycleOwner){
                textviewJellyfishScore.text = clickerViewModel.jellyfishScoreLiveData.value.toString()
            }

            clickerViewModel.imageButtonSrcLiveData.observe(viewLifecycleOwner){
                imageButton.setImageResource(clickerViewModel.imageButtonSrcLiveData.value?.toInt() ?: R.drawable.ic_launcher_background)
            }

            imageButton.setOnClickListener {
                changeScore()
                changeImage()
            }
        }

        return binding.root
    }

    enum class Images(val drawable: Int) {
        HEDGEHOG(R.drawable.hedgehog_svg),
        SHRIMP(R.drawable.shrimp_svg),
        JELLYFISH(R.drawable.jellyfish_svg)
    }

    private fun changeScore(){
        when(binding.imageButton.tag){
            Images.SHRIMP.drawable -> clickerViewModel.incrementShrimpScore()
            Images.HEDGEHOG.drawable -> clickerViewModel.incrementHedgehogScore()
            Images.JELLYFISH.drawable -> clickerViewModel.incrementJellyfishScore()
        }
    }

    private fun changeImage(){
        val newImage = Images.entries.random().drawable

        binding.imageButton.setImageResource(newImage)
        binding.imageButton.tag = newImage

        clickerViewModel.changeImageButton(newImage)
    }
}