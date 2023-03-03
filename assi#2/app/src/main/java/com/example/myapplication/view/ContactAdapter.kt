package com.example.myapplication.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.model.ContactData

class ContactAdapter(val c: Context, val contactList: ArrayList<ContactData>) :
    RecyclerView.Adapter<ContactAdapter.UserViewHolder>() {


    inner class UserViewHolder(val v: View) : RecyclerView.ViewHolder(v) {
        var name: TextView
        var phone_number: TextView
        var address: TextView
        var delete: ImageView

        init {
            name = v.findViewById<TextView>(R.id.name)
            phone_number = v.findViewById<TextView>(R.id.phoneNumber)
            address = v.findViewById<TextView>(R.id.address)
            delete = v.findViewById(R.id.delete)
            delete.setOnClickListener {
                Toast.makeText(c,"show show show",Toast.LENGTH_SHORT).show()
            }
        }

//        private fun popupMenus(v: View) {
//            val position = contactList[adapterPosition]
//            val popupMenus = PopupMenu(c, v)
//
//            popupMenus.show()
//            val popup = PopupMenu::class.java.getDeclaredField("mPopup")
//            popup.isAccessible = true
//            val menu = popup.get(popupMenus)
//            menu.javaClass.getDeclaredMethod("setForceShowIcon", Boolean::class.java)
//                .invoke(menu, true)
//        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.rv_item, parent, false)
        return UserViewHolder(v)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val newList = contactList[position]
        holder.name.text = newList.name
        holder.phone_number.text = newList.phone_number
        holder.address.text = newList.address
    }

    override fun getItemCount(): Int {
        return contactList.size
    }
}