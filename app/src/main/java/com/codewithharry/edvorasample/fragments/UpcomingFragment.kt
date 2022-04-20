package com.codewithharry.edvorasample.fragments

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codewithharry.edvorasample.MainActivity
import com.codewithharry.edvorasample.NearestAdapter
import com.codewithharry.edvorasample.R
import com.codewithharry.edvorasample.Ride

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [UpcomingFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class UpcomingFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var recyclerView: RecyclerView? = null
    private var mContext: Context? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        recyclerView = inflater.inflate(R.layout.fragment_upcoming, container, false) as RecyclerView?
        recyclerView?.layoutManager = LinearLayoutManager(activity)
        return recyclerView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = mContext?.let { NearestAdapter(it) }
        recyclerView?.adapter = adapter

        if (MainActivity.API_STATUS) {
            UpcomingFragment.adapter?.setRideList(UpcomingFragment.upcomingRidesList)
        }
    }

    override fun onStart() {
        super.onStart()
//        adapter?.setRideList(UpcomingFragment.upcomingRidesList)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment UpcomingFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            UpcomingFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }

        @SuppressLint("StaticFieldLeak")
        var adapter: NearestAdapter? = null
        var upcomingRidesList: MutableList<Ride>? = null
    }
}