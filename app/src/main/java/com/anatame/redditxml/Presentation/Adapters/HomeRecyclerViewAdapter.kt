package com.anatame.redditxml.Presentation.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.anatame.redditxml.R
import com.anatame.redditxml.data.remote.PostDetail
import com.bumptech.glide.Glide
import com.bumptech.glide.Glide.with
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.with


class HomeRecyclerViewAdapter(private val dataSet: List<PostDetail>, private val context: Context) :
    RecyclerView.Adapter<HomeRecyclerViewAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.tv_subredditName)
        val subredditIcon: ImageView = view.findViewById(R.id.iv_subredditIcon)
        val postImage: ImageView = view.findViewById(R.id.iv_postImage)
        val postTitle: TextView = view.findViewById(R.id.tv_postTitle)
        val postDesc: TextView = view.findViewById(R.id.tv_postDescription)
        val postAuthor: TextView = view.findViewById(R.id.tv_poster)
        val postCardView: CardView = view.findViewById(R.id.cardView)

        init {

            // Define click listener for the ViewHolder's View.
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.home_recyclerview_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        Glide.with(context)
            .load(dataSet[position].thumbnail)
            .into(viewHolder.postImage)

        viewHolder.textView.text = dataSet[position].subRedditName
        viewHolder.postTitle.text = dataSet[position].title
        viewHolder.postDesc.text = dataSet[position].description
        viewHolder.postAuthor.text = "posted by ${dataSet[position].authorName}"
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}