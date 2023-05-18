package com.example.task4.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.task4.R
import com.example.task4.databinding.FragmentDetailBinding
import com.example.task4.util.downloadFromUrl

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailBinding.bind(view)

        printCryptoData()
        binding.detailScreenToolBar.backToolBar.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun printCryptoData() {
        val cryptoDataArgs = args.crypto
        cryptoDataArgs.let {
            binding.apply {
                detailScreenIv.downloadFromUrl(cryptoDataArgs.image)
                detailScreenNameTv.text = cryptoDataArgs.name
                detailScreenYearTv.text = cryptoDataArgs.yearEstablished.toString()
                detailScreenCountryTv.text = cryptoDataArgs.country
                detailScreenDescriptionTv.text = cryptoDataArgs.description
                detailScreenTrustScoreTv.text = cryptoDataArgs.trustScore.toString()
                detailScreenTrustScoreRankTv.text = cryptoDataArgs.trustScoreRank.toString()
                detailScreenTradeVolume24hBtcTv.text = cryptoDataArgs.tradeVolume.toString()
                detailScreenTradeVolume24hBtcNormalizedTv.text =
                    cryptoDataArgs.tradeVolumeNormalized.toString()
            }
        }
    }
}