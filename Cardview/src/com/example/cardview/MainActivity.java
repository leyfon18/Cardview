package com.example.cardview;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {		
    @Override
    protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_main);
          RecyclerView recList = (RecyclerView) findViewById(R.id.cardList);
          recList.setHasFixedSize(true);
          LinearLayoutManager llm = new LinearLayoutManager(this);
          llm.setOrientation(LinearLayoutManager.VERTICAL);
          recList.setLayoutManager(llm);
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
	    private String[] mDataset;

	    // Provide a reference to the views for each data item
	    // Complex data items may need more than one view per item, and
	    // you provide access to all the views for a data item in a view holder
	    public static class ViewHolder extends RecyclerView.ViewHolder {
	        // each data item is just a string in this case
	        public TextView mTextView;
	        public ViewHolder(TextView v) {
	            super(v);
	            mTextView = v;
	        }
	    }

	    // Provide a suitable constructor (depends on the kind of dataset)
	    public MyAdapter(String[] myDataset) {
	        mDataset = myDataset;
	    }

	    // Create new views (invoked by the layout manager)
	    @Override
	    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
	                                                   int viewType) {
	        // create a new view
	        View v = LayoutInflater.from(parent.getContext())
	                               .inflate(R.layout.my_text_view, parent, false);
	        // set the view's size, margins, paddings and layout parameters
	        ...
	        ViewHolder vh = new ViewHolder(v);
	        return vh;
	    }

	    // Replace the contents of a view (invoked by the layout manager)
	    @Override
	    public void onBindViewHolder(ViewHolder holder, int position) {
	        // - get element from your dataset at this position
	        // - replace the contents of the view with that element
	        holder.mTextView.setText(mDataset[position]);

	    }

	    // Return the size of your dataset (invoked by the layout manager)
	    @Override
	    public int getItemCount() {
	        return mDataset.length;
	    }
	}
	
}
