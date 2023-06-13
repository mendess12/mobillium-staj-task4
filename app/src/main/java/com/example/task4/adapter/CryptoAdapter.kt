import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.task4.R
import com.example.task4.model.CryptoListItem
import com.example.task4.ui.list.ListFragmentDirections
import com.example.task4.util.downloadFromUrl
import java.util.Locale

class CryptoAdapter() :
    RecyclerView.Adapter<CryptoAdapter.MyViewHolder>(), Filterable {

    var cryptoData: MutableList<CryptoListItem> = arrayListOf()
    var filterList: MutableList<CryptoListItem> = arrayListOf()

    class MyViewHolder(iteView: View) : RecyclerView.ViewHolder(iteView) {

        var name: TextView = iteView.findViewById(R.id.recycler_row_name_tv)
        var year: TextView = iteView.findViewById(R.id.recycler_row_year_tv)
        var country: TextView = iteView.findViewById(R.id.recycler_row_country_tv)
        var image: ImageView = iteView.findViewById(R.id.recycler_row_iv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_row, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return filterList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val cryptoDataPosition = filterList[position]
        holder.name.text = cryptoDataPosition.name
        holder.country.text = cryptoDataPosition.country
        holder.year.text = cryptoDataPosition.yearEstablished.toString()
        holder.image.downloadFromUrl(cryptoDataPosition.image)

        holder.itemView.setOnClickListener {
            val action =
                ListFragmentDirections.actionListFragmentToDetailFragment(cryptoDataPosition.id)
            Navigation.findNavController(it).navigate(action)
        }
    }

    //filtreleme işlemleri
    override fun getFilter(): Filter {
        return object : Filter() {
            override fun publishResults(constraint: CharSequence, results: FilterResults) {
                filterList = results.values as MutableList<CryptoListItem>
                notifyDataSetChanged()
            }

            override fun performFiltering(constraint: CharSequence): FilterResults {
                val filteredResults: List<CryptoListItem?> = if (constraint.isEmpty()) {
                    cryptoData
                } else {
                    getFilteredResults(constraint.toString().lowercase(Locale.getDefault()))
                }
                val results = FilterResults()
                results.values = filteredResults
                return results
            }
        }
    }

    //filtre sonuçları
    private fun getFilteredResults(constraint: String?): List<CryptoListItem> {
        val results: MutableList<CryptoListItem> = ArrayList()
        for (item in cryptoData) {
            if (item.name.lowercase().contains(constraint!!)) {
                results.add(item)
            }
        }
        return results
    }

    fun updateData(crypto: List<CryptoListItem>) {
        filterList.clear()
        filterList.addAll(crypto)
        cryptoData.clear()
        cryptoData.addAll(crypto)
        notifyDataSetChanged()
    }
}