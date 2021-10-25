package raj.training.recyclerviewdemo1

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var myRecyclerView: RecyclerView
    private val fruitsList = listOf(Fruit("Mango", "Tom"), Fruit("Apple", "Joe"), Fruit("Banana", "Mark"), Fruit("Guava", "Mike"), Fruit("Lemon", "Mike"), Fruit("Pear", "Frank"), Fruit("Orange", "Joe"))
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myRecyclerView = findViewById(R.id.my_recycler_view)
        myRecyclerView.setBackgroundColor(Color.YELLOW)
        myRecyclerView.layoutManager = LinearLayoutManager(this)
        myRecyclerView.adapter = MyRecyclerViewAdapter(fruitsList, {selectedFruitItem -> listItemClicked(selectedFruitItem)})
    }

    private fun listItemClicked(fruit: Fruit){
        Toast.makeText(this, "Supplier name is ${fruit.supplier}", Toast.LENGTH_LONG).show()
    }
}