import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.appzlogic.fatchusers.R
import com.appzlogic.fatchusers.databinding.UserRwoItemBinding
import com.appzlogic.fetchuser.model.UsersItem

class UserAdapter : RecyclerView.Adapter<UserAdapter.ItemViewHolder>() {

    private var listener: ((UsersItem) -> Unit)? = null
    private var itemList = mutableListOf<UsersItem>()

    fun setItemList(itemList: List<UsersItem>) {
        this.itemList = itemList.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = UserRwoItemBinding.inflate(inflater, parent, false)
        return ItemViewHolder(binding)
    }
    fun itemClickListener(l: (UsersItem) -> Unit) {
        listener = l
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val itemLists = itemList[position]

        holder.binding.tvName.text = itemLists.name
        holder.binding.tvCity.text = itemLists.address.city
        holder.binding.tvUserName.text = itemLists.username
        holder.binding.tvCompany.text = itemLists.company.name
        holder.binding.tvEmail.text = itemLists.email
        holder.binding.tvWebsite.text = itemLists.website
        holder.binding.imgFav.setOnClickListener {
            holder.binding.imgFav.setImageResource(R.drawable.ic_fav_two)
            listener?.let {
                it(this.itemList[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    class ItemViewHolder(val binding: UserRwoItemBinding) : RecyclerView.ViewHolder(binding.root) {
    }
}