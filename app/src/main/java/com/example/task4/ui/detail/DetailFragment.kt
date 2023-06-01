package com.example.task4.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.task4.R
import com.example.task4.databinding.FragmentDetailBinding
import com.example.task4.model.CryptoDetail
import com.example.task4.util.downloadFromUrl
import com.example.task4.util.showSnackBar

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private val args: DetailFragmentArgs by navArgs()
    private val viewModel: DetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailBinding.bind(view)

        viewModel.cryptoDetailDataFromAPI(args.cryptoId)
        observeLiveData()
        binding.detailScreenToolBar.backToolBar.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun observeLiveData() {
        viewModel.cryptoDataDetail.observe(viewLifecycleOwner) {
            if (it != null) {
                printData(it)
            } else {
                view?.showSnackBar("Detail list is empty!")
            }
        }
    }

    private fun printData(cryptoDetail: CryptoDetail) {
        binding.apply {
            detailScreenIv.downloadFromUrl(cryptoDetail.image)
            detailScreenNameTv.text = cryptoDetail.name
            detailScreenYearTv.text = cryptoDetail.yearEstablished.toString()
            detailScreenCountryTv.text = cryptoDetail.country
            detailScreenDescriptionTv.text = cryptoDetail.description
            detailScreenTrustScoreTv.text = cryptoDetail.trustScore.toString()
            detailScreenTrustScoreRankTv.text = cryptoDetail.trustScoreRank.toString()
            detailScreenTradeVolume24hBtcTv.text = cryptoDetail.tradeVolume.toString()
            detailScreenTradeVolume24hBtcNormalizedTv.text =
                cryptoDetail.tradeVolumeNormalized.toString()
            detailScreenFacebookUrl.text = cryptoDetail.facebookUrl

            detailScreenFacebookUrl.setOnClickListener {
                webView.loadUrl(cryptoDetail.facebookUrl)
            }
        }
    }

}