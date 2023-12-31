package com.example.playlistmaker

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

class TrackViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {
    private val trackImage: ImageView = itemView.findViewById(R.id.trackImage)
    private val trackNameField: TextView = itemView.findViewById(R.id.trackNameField)
    private val artistNameField: TextView = itemView.findViewById(R.id.artistNameField)
    private val trackTimeField: TextView = itemView.findViewById(R.id.trackTimeField)

    infix fun bind (item: Track){
        Glide.with(itemView)
            .load(item.artworkUrl100)
            .placeholder(R.drawable.placeholder)
            .centerCrop()
            .transform(RoundedCorners(2))
            .into(trackImage)
        trackNameField.text = item.trackName
        artistNameField.text = item.artistName
        trackTimeField.text = item.trackTime
    }
}