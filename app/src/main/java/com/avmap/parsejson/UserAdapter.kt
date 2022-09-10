package com.avmap.parsejson

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.avmap.parsejson.databinding.ItemUserLayoutBinding
import com.avmap.parsejson.model.UserModelClass


class UserAdapter( private val activity: Activity,
                   private val items: ArrayList<UserModelClass> ) :
    RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    /**
     * Inflates the item views which is designed in xml layout file
     *
     * create a new
     * {@link ViewHolder} and initializes some private fields to be used by RecyclerView.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemUserLayoutBinding = ItemUserLayoutBinding
            .inflate(LayoutInflater.from(activity), parent, false)

        return ViewHolder(binding)
    }

    /**
     * Binds each item in the ArrayList to a view
     *
     * Called when RecyclerView needs a new {@link ViewHolder} of the given type to represent
     * an item.
     *
     * This new ViewHolder should be constructed with a new View that can represent the items
     * of the given type. You can either create a new View manually or inflate it from an XML
     * layout file.
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = items[position]

        holder.tvId.text = item.id.toString()
        holder.tvName.text = item.name
        holder.tvEmail.text = item.email
        holder.tvGender.text = item.gender
        holder.tvWeight.text = item.weight.toString()
        holder.tvHeight.text = item.height.toString()
        holder.tvMobileNumber.text = item.phone.mobile
        holder.tvOfficeNumber.text = item.phone.office
    }

    /**
     * Gets the number of items in the list
     */
    override fun getItemCount(): Int {
        return items.size
    }

    /**
     * A ViewHolder describes an item view and metadata about its place within the RecyclerView.
     */
    class ViewHolder(view: ItemUserLayoutBinding) : RecyclerView.ViewHolder(view.root) {
        // Holds the TextView that will add each item to
        val tvId = view.tvId
        val tvName = view.tvName
        val tvEmail = view.tvEmail
        val tvGender = view.tvGender
        val tvWeight = view.tvWeight
        val tvHeight = view.tvHeight
        val tvMobileNumber = view.tvMobile
        val tvOfficeNumber = view.tvOfficeNumber
    }

}