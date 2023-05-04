package com.anitac.photoexpo.view



import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anitac.photoexpo.ImageList
import com.anitac.photoexpo.databinding.CvHomeImageListBinding
import com.squareup.picasso.Picasso
import java.util.*

/**
 * @author Anita Chipkar
 * @property mActivity
 * @constructor
 * @param onRecyclerClick
 */
class ImageListAdapter(
    onRecyclerClick: RecyclerViewActionListener,
    val mActivity: Activity
) : RecyclerView.Adapter<ImageListAdapter.ViewHolder>() {

    val TAG: String = ImageListAdapter::class.java.simpleName

    val mOnRecyclerClick = onRecyclerClick
    var mOriginalData = ArrayList<ImageList>()
    var mResultData = ArrayList<ImageList>()
    var nextPage: Int = 1

    //How much total items we want to load on this adapter.
    var totalCount: String = "0"


    /**
     * @author Anita Chipkar
     * @param parent
     * @param viewType
     * @return
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CvHomeImageListBinding.inflate(inflater)
        val lp = RecyclerView.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        binding.root.layoutParams = lp
        return ViewHolder(binding)
    }

    /**
     * @author Anita Chipkar
     * @param holder
     * @param position
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(mResultData[position])


    fun getItem(index: Int): ImageList {
        return mResultData[index]
    }

    fun getAllItems(): ArrayList<ImageList> {
        return mResultData
    }

    fun addItem(data: ImageList) {
        mOriginalData.add(data)
        mResultData.add(data)
        val index = mOriginalData.indexOf(data)
        notifyItemInserted(index)
    }

    fun addAllItem(data: List<ImageList>) {
        mOriginalData.addAll(data)
        mResultData.addAll(data)
        notifyDataSetChanged()
    }

    fun removeItem(index: Int) {
        mOriginalData.removeAt(index)
        mResultData.removeAt(index)
        notifyItemRemoved(index)
    }


    fun removeAll() {
        mOriginalData.clear()
        mResultData.clear()
        nextPage = 1
        notifyDataSetChanged()
    }

    fun replaceItem(index: Int, item: ImageList) {
        mOriginalData[index] = item
        notifyItemChanged(index)
    }

    fun removeItem(data: ImageList) {
        val index = mOriginalData.indexOf(data)
        mOriginalData.remove(data)
        notifyItemRemoved(index)
    }

    override fun getItemCount() = mResultData.size


    inner class ViewHolder(val binding: CvHomeImageListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ImageList) {
            with(binding) {
                binding.imageItem = item
                Picasso.get().load(item.thumbnailUrl).into(binding.ivThumbnail);

                binding.cvImageItem.setOnClickListener {
                    mOnRecyclerClick.onItemClick(cvImageItem.id, adapterPosition, null)
                }
                binding.executePendingBindings()
                if (layoutPosition == (mOriginalData.size - 1) && mOriginalData.size < totalCount.toInt()) {
                    mOnRecyclerClick.onLoadMore(itemCount = mOriginalData.size, nextPage = nextPage)
                }

            }
        }
    }

}