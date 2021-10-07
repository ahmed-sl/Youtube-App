package com.example.youtubeapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import kotlinx.android.synthetic.main.video_row.view.*

class vdAdapter (val videolist: Array<Array<String>>, val player: YouTubePlayer):
        RecyclerView.Adapter<vdAdapter.videoItemHolder>() {
    class videoItemHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val button: Button = itemView.btVideo
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): videoItemHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.video_row,
            parent,
            false
        )
        return videoItemHolder(itemView)
    }

    override fun onBindViewHolder(holder: videoItemHolder, position: Int) {
        val currentTitle = videolist[position][0]
        val currentLink = videolist[position][1]
        holder.button.text = currentTitle
        holder.button.setOnClickListener {
            player.loadVideo(currentLink, 0f)
        }
    }

    override fun getItemCount() = videolist.size

}