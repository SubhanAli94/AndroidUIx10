package com.ali.androidUIx10

import android.media.Image
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.ali.androidUIx10.databinding.ItemProductBinding
import com.bumptech.glide.Glide

class RecyclerViewActivity : AppCompatActivity() {

    private val sampleImageList = listOf(
        ImageItem(
            name = "City Skyline at Night",
            url = "https://images.pexels.com/photos/417344/pexels-photo-417344.jpeg"
        ),
        ImageItem(
            name = "Serene Beach",
            url = "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg"
        ),
        ImageItem(
            name = "Snowy Mountains",
            url = "https://images.pexels.com/photos/547115/pexels-photo-547115.jpeg"
        ),
        ImageItem(
            name = "City Skyline at Night",
            url = "https://images.pexels.com/photos/417344/pexels-photo-417344.jpeg"
        ),
        ImageItem(
            name = "Serene Beach",
            url = "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg"
        ),
        ImageItem(
            name = "Snowy Mountains",
            url = "https://images.pexels.com/photos/547115/pexels-photo-547115.jpeg"
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycler_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val adapter = ItemAdapter(sampleImageList) { item ->
            println(item.name)
        }


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)


        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter


        //recyclerView.layoutManager = GridLayoutManager(this, 2)
        //recyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

    }
}

class ItemAdapter(private val data: List<ImageItem>, private val listener: (item: ImageItem) -> Unit) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        val binding = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return data.count()
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(data[position])
    }

    inner class ItemViewHolder(val binding: ItemProductBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(itemData: ImageItem) {
            println(itemData.url)

            binding.itemText.text = itemData.name
            Glide.with(binding.image.context)
                .load(itemData.url)
                .into(binding.image)

            binding.root.setOnClickListener {
                listener(itemData)
            }
        }

    }
}

data class ImageItem(
    val name: String,
    val url: String
)