package com.sanskriti.quiz

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load

class SlideAdapter(private val context: android.content.Context) : 
    RecyclerView.Adapter<SlideAdapter.SlideViewHolder>() {

    private val slides = listOf(
        Slide(
            imageUrl = "https://images.unsplash.com/photo-1503676260728-1c00da094a0b",
            title = "Welcome to Sanskriti"
        ),
        Slide(
            imageUrl = "https://images.unsplash.com/photo-1456513080510-7bf3a84b82f8",
            title = "Where Words Meet Wisdom"
        ),
        Slide(
            imageUrl = "https://images.unsplash.com/photo-1471107340929-a87cd0f5b5e3",
            title = "Start Your Journey"
        )
    )

    inner class SlideViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.slideImage)
        val text: TextView = view.findViewById(R.id.slideText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SlideViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.slide_item, parent, false)
        return SlideViewHolder(view)
    }

    override fun onBindViewHolder(holder: SlideViewHolder, position: Int) {
        val slide = slides[position]
        holder.image.load(slide.imageUrl) {
            crossfade(true)
            placeholder(R.drawable.placeholder_image)
        }
        holder.text.text = slide.title
    }

    override fun getItemCount(): Int = slides.size
}

data class Slide(
    val imageUrl: String,
    val title: String
)