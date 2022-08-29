import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.appzlogic.fatchusers.R
import com.appzlogic.fatchusers.database.User
import com.appzlogic.fatchusers.databinding.FavUserItemBinding
import com.appzlogic.fatchusers.databinding.UserRwoItemBinding
import com.appzlogic.fetchuser.model.UsersItem

class FavUserAdapter : RecyclerView.Adapter<FavUserAdapter.ItemViewHolder>() {

    private var itemList = mutableListOf<User>()

    fun setItemList(itemList: List<User>) {
        this.itemList = itemList.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = FavUserItemBinding.inflate(inflater, parent, false)
        return ItemViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val itemLists = itemList[position]

        holder.binding.tvName.text = itemLists.name
        holder.binding.tvCity.text = itemLists.city
        holder.binding.tvUserName.text = itemLists.userName
        holder.binding.tvCompany.text = itemLists.company
        holder.binding.tvEmail.text = itemLists.email
        holder.binding.tvWebsite.text = itemLists.website
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    class ItemViewHolder(val binding: FavUserItemBinding) : RecyclerView.ViewHolder(binding.root) {
    }
}