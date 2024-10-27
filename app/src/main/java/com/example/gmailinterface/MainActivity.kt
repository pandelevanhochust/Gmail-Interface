package com.example.gmailinterface

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    data class mail(val imgId: Int, val title: String, val message: String)

    class ItemAdapter(private val context: Context, private val items: ArrayList<mail>) : BaseAdapter() {
        override fun getCount(): Int {
            return items.size
        }

        override fun getItem(position: Int): Any {
            return items[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val view: View = convertView ?: LayoutInflater.from(context).inflate(R.layout.item, parent, false)
            val item = items[position]

            val imgView: ImageView = view.findViewById(R.id.item_image)
            val titleView: TextView = view.findViewById(R.id.item_title)
            val messageView: TextView = view.findViewById(R.id.item_message)

            imgView.setImageResource(item.imgId)
            titleView.text = item.title
            messageView.text = item.message

            return view
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val list: ArrayList<mail> = arrayListOf(
            mail(R.mipmap.ic_launcher_foreground, "Kurt", "hello how low"),
            mail(R.mipmap.ic_launcher_huong, "Thom York", "I am not special"),
            mail(R.mipmap.ic_launcher_johncena, "Chris Cornell", "Like a stone"),
            mail(R.mipmap.ic_launcher_tlv, "Axl Rose", "she got a smile that seems to me"),
            mail(R.mipmap.ic_launcher_yaphet, "Kurt", "load up your guns"),
            mail(R.mipmap.ic_launcher_tlv2, "Kurt", "and bring some friends"),
            mail(R.mipmap.ic_launcher_tlv2, "Kurt", "its fun to lose and to pretend"),
            mail(R.mipmap.ic_launcher_johncena, "Kurt", "she overbored and self assure"),
            mail(R.mipmap.ic_launcher_tlv2, "Kurt", "oh no I know a dirty word "),
            mail(R.mipmap.ic_launcher_yaphet, "Kurt", "hello how low"),
            mail(R.mipmap.ic_launcher_huong, "Kurt", "hello how low"),
            mail(R.mipmap.ic_launcher_yaphet, "Kurt", "hello how low"),
            mail(R.mipmap.ic_launcher_johncena, "Kurt", "hello how low"),
            mail(R.mipmap.ic_launcher_foreground, "Kurt", "hello how low"),
            mail(R.mipmap.ic_launcher, "Kurt", "hello how low"),
            mail(R.mipmap.ic_launcher_tlv, "Kurt", "hello how low"),
            mail(R.mipmap.ic_launcher, "Kurt", "hello how low")

        )

        val listView = findViewById<ListView>(R.id.my_list)
        val adapter = ItemAdapter(this, list)
        listView.adapter = adapter
    }
}
