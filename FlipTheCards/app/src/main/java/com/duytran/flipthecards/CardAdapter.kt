package com.duytran.flipthecards

import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.duytran.flipthecards.model.DataCards

class CardAdapter(private val cards: List<DataCards>, private val recyclerView: RecyclerView) : RecyclerView.Adapter<CardAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageViewFont: ImageView = itemView.findViewById(R.id.imageViewFont)
        val imageViewBack: ImageView = itemView.findViewById(R.id.imageViewBack)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val card = cards[position]
        holder.imageViewBack.setImageResource(R.drawable.person9)
        holder.imageViewFont.setImageResource(card.image)

        holder.itemView.setOnClickListener {
            if (!card.isFlipped) {
                holder.imageViewFont.visibility = View.GONE
                holder.imageViewBack.visibility = View.VISIBLE
                card.isFlipped = true
            }else{
                holder.imageViewFont.visibility = View.VISIBLE
                holder.imageViewBack.visibility = View.GONE
                card.isFlipped = false
            }

        /*var firstCard: DataCards? = null
        var firstCardPosition: Int? = null

        holder.itemView.setOnClickListener {
            if (!card.isFlipped) {
                holder.imageViewFont.visibility = View.GONE
                holder.imageViewBack.visibility = View.VISIBLE
                card.isFlipped = true

                if (firstCard == null) {
                    firstCard = card
                    firstCardPosition = position
                } else {
                    if (card.id == firstCard!!.id) {
                        // trung nhau
                        firstCard = null
                        firstCardPosition = null
                    } else {
                        // k trung nhau
                        Handler(Looper.getMainLooper()).postDelayed({
                            holder.imageViewFont.visibility = View.VISIBLE
                            holder.imageViewBack.visibility = View.GONE
                            card.isFlipped = false

                            val firstCardHolder = recyclerView.findViewHolderForAdapterPosition(firstCardPosition!!) as ViewHolder
                            firstCardHolder.imageViewFont.visibility = View.VISIBLE
                            firstCardHolder.imageViewBack.visibility = View.GONE
                            firstCard!!.isFlipped = false

                            firstCard = null
                            firstCardPosition = null
                        }, 6000)
                    }
                }
            }*/
        }
    }

    override fun getItemCount(): Int {
        return cards.size
    }
}