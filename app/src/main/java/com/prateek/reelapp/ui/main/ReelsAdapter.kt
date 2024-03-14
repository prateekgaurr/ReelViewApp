package com.prateek.reelapp.ui.main

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.prateek.reelapp.databinding.ItemReelBinding
import com.prateek.reelapp.models.GoogleSearchResultsApiResponse
import com.prateek.reelapp.util.ExoplayerManager
import javax.inject.Inject

class ReelsAdapter @Inject constructor() : RecyclerView.Adapter<ReelsAdapter.ViewHolder>() {

    private val list = mutableListOf<GoogleSearchResultsApiResponse.ShortVideo>()
    private var listener : ReelInterface? = null

    inner class ViewHolder(private var binding: ItemReelBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("ClickableViewAccessibility")
        fun bind(item: GoogleSearchResultsApiResponse.ShortVideo, isFirstItem : Boolean, isLastItem : Boolean, position : Int) {
            binding.apply {
                exoplayerView.player = ExoplayerManager.getExoPlayerInstance()

//                exoplayerView.setOnTouchListener { v, event ->
//                    if (event.action == MotionEvent.ACTION_DOWN) {
//                        exoplayerView.player?.pause()
//                    }else if(event.action == MotionEvent.ACTION_UP) {
//                        exoplayerView.player?.play()
//                    }
//                    true
//                }

                btLike.setOnClickListener {
                    listener?.onReelLikeUnlikeClicked(item)
                }

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(ItemReelBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(list[position], position == 0 ,position == list.size-1, position)

    fun updateList(newList: List<GoogleSearchResultsApiResponse.ShortVideo>) {
        Log.d("TAG", "updateList: list of URL --> ${newList.map { it.clip }}")
        val diffResult = DiffUtil.calculateDiff(DiffCallback(list, newList))
        list.clear()
        list.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }

    fun setClickListener(listener : ReelInterface) {
        this.listener = listener
    }


    //diff
    private class DiffCallback(
        private val oldList: List<GoogleSearchResultsApiResponse.ShortVideo>,
        private val newList: List<GoogleSearchResultsApiResponse.ShortVideo>
    ) : DiffUtil.Callback() {
        override fun getOldListSize() = oldList.size
        override fun getNewListSize() = newList.size
        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            oldList[oldItemPosition].clip == newList[newItemPosition].clip

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            oldList[oldItemPosition] == newList[newItemPosition]
    }


}

interface ReelInterface {
    fun onReelClicked(reel: GoogleSearchResultsApiResponse.ShortVideo)
    fun onReelLikeUnlikeClicked(reel: GoogleSearchResultsApiResponse.ShortVideo)
}
