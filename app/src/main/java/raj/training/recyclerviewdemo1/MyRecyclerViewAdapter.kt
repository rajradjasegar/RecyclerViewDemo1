package raj.training.recyclerviewdemo1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyRecyclerViewAdapter(private val fruitsList: List<Fruit>, private val clickListener: (Fruit) -> Unit) : RecyclerView.Adapter<MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.list_item, parent, false)
        return MyViewHolder(listItem)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // on peut également faire comme ci dessous mais dans la programmation orienté objet
        // il vaut mieux laissé l'affectation dans le MyViewHolder avec la méthode bind
        //holder.textView.text = fruitsList[position].name
        holder.bind(fruitsList[position], clickListener)
    }

    override fun getItemCount(): Int {
        return fruitsList.size
    }
}

class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    private val textView: TextView = view.findViewById(R.id.name_text_view)

    fun bind(fruit: Fruit, clickListener: (Fruit) -> Unit) {
        textView.text = fruit.name
        view.setOnClickListener {
            clickListener(fruit)
        }
    }
}