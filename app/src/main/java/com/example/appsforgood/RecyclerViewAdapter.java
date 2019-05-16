package com.example.appsforgood;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * The adapter for the volunteer's Hour Log recycler view
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<LogEntry> logEntries;
    private Context context;

    /**
     * Constructs the adapter
     * @param con context
     * @param logEntriesList ArrayList of the volunteer's log entries
     */
    public RecyclerViewAdapter(Context con, ArrayList<LogEntry> logEntriesList) {
        logEntries = logEntriesList;
        context = con;
    }

    /**
     *
     * @param parent the recycler view
     * @param viewType
     * @return a list item at a specific index
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hourlog_listitem, parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    /**
     * Assigns the information of a volunteer to the corresponding list item text views depending the index
     * @param holder the list item
     * @param position the index of the volunteer within the ArrayList and the corresponding list item
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    {
        Log.d(TAG,"onBindViewHolder: called.");

        holder.charity.setText(logEntries.get(position).getCharityName());
        holder.numberOfHours.setText(logEntries.get(position).getStringHours());
        holder.date.setText(logEntries.get(position).getDate());
        holder.contactInfo.setText(logEntries.get(position).getContactEmail());
        holder.approval.setText(logEntries.get(position).getStringApprovalStatus());
    }

    /**
     * Gets the number of items in the list of log entries
     * @return number of items
     */
    @Override
    public int getItemCount()
    {
        return logEntries.size();
    }

    /**
     * assigns the text views within the list item to a name
     */
    public class ViewHolder extends RecyclerView.ViewHolder{

        RelativeLayout parentLayout;

        TextView charity;
        TextView numberOfHours;
        TextView date;
        TextView contactInfo;
        TextView approval;

        /**
         * defines what each text view within the list item is
         * @param itemView the list item
         */
        public ViewHolder(View itemView)
        {
            super(itemView);
            parentLayout = itemView.findViewById(R.id.parent_layout);

            charity = itemView.findViewById(R.id.charity);
            numberOfHours = itemView.findViewById(R.id.number_of_hours);
            date = itemView.findViewById(R.id.date);
            contactInfo = itemView.findViewById(R.id.contactInfo);
            approval = itemView.findViewById(R.id.approval);
        }
    }
}