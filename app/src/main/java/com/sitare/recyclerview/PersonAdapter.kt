package com.sitare.recyclerview

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.widget.PopupMenu
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.sitare.recyclerview.databinding.CardViewBinding

class PersonAdapter(var mContext: Context, var personList: List<Person>)
    :RecyclerView.Adapter<PersonAdapter.CardViewHolder>() {

    inner class CardViewHolder(cardViewBinding: CardViewBinding)
        : RecyclerView.ViewHolder(cardViewBinding.root) {

                var cardDesign:CardViewBinding

                init {
                    this.cardDesign = cardViewBinding
                }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val design = CardViewBinding.inflate(layoutInflater, parent, false)
        return CardViewHolder(design)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val person = personList.get(position)
        //holder.cardDesign.PersonInfo.text = "${person.name} - ${person.telephone}"
        //data binding
        holder.cardDesign.person = person

        //to reach person card, we will use holder
        holder.cardDesign.personCard.setOnClickListener {
            //Toast.makeText(mContext, "${person.name} is tapped!", Toast.LENGTH_SHORT).show()
            val action = HomeFragmentDirections.toDetailFragmentAction(person)
            Navigation.findNavController(it).navigate(action)
        }

        holder.cardDesign.moreImageView.setOnClickListener {
            val popUp = PopupMenu(mContext, it)
            popUp.menuInflater.inflate(R.menu.card_menu, popUp.menu)
            popUp.show()

            popUp.setOnMenuItemClickListener { item ->
                when(item.itemId) {
                    R.id.action_delete -> {
                        Snackbar.make(it, "${person.name} will deleted", Snackbar.LENGTH_SHORT)
                                .setAction("OK") {
                                    //delete from DB here
                                    //notify user after deletion
                                    Snackbar.make(it, "${person.name} deleted", Snackbar.LENGTH_SHORT).show()

                                }.setActionTextColor(Color.RED)
                                .show()
                        true
                    }
                    R.id.action_update -> {
                        Snackbar.make(it, "${person.name} updated", Snackbar.LENGTH_SHORT).show()
                        true
                    }
                    else -> false

                }

            }
        }

    }

    override fun getItemCount(): Int {
        return personList.size
    }

}