package com.anitac.photoexpo.view

interface RecyclerViewActionListener {
    /**
     * @author Anita Chipkar
     * This function is call when user click on recycler view element
     */
    fun onItemClick(viewId: Int, position: Int, childPosition: Int?)

    /**
     * @author Anita Chipkar
     * This method call when recycler view reach at last element/position.
     * And want to load more items
     */
    fun onLoadMore(itemCount: Int, nextPage: Int)
}