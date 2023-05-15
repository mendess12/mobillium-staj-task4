import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.task4.R
import com.example.task4.model.CryptoListItem
import com.example.task4.util.downloadFromUrl

class CryptoAdapter(private val cryptoData: List<CryptoListItem>, private val listener: Listener) :
    RecyclerView.Adapter<CryptoAdapter.MyViewHolder>() {

    interface Listener {
        fun onItemClick(cryptoData: CryptoListItem)
    }

    class MyViewHolder(iteView: View) : RecyclerView.ViewHolder(iteView) {
        fun bind(cryptoData: CryptoListItem, listener: Listener) {
            itemView.setOnClickListener {
                listener.onItemClick(cryptoData)
            }
        }

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
        return cryptoData.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.bind(cryptoData[position], listener)

        val cryptoDataPosition = cryptoData[position]
        holder.name.text = cryptoDataPosition.name
        holder.country.text = cryptoDataPosition.country
        holder.year.text = cryptoDataPosition.yearEstablished.toString()
        holder.image.downloadFromUrl(cryptoDataPosition.image)

        holder.itemView.setOnClickListener {
            listener.onItemClick(cryptoData[position])
        }
    }
}