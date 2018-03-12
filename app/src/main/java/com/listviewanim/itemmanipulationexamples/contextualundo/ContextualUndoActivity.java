package com.listviewanim.itemmanipulationexamples.contextualundo;

import android.os.Bundle;

import com.listviewanim.MyListActivity;
import com.listviewanim.R;
import com.listviewanim.adapter.ArrayAdapter;
import com.listviewanim.adapter.contextualundo.ContextualUndoAdapter;


public class ContextualUndoActivity extends MyListActivity {

	private final ArrayAdapter<String> mAdapter = createListAdapter();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		ContextualUndoAdapter contextualUndoAdapter = new ContextualUndoAdapter(mAdapter, R.layout.undo_row, R.id.undo_row_undobutton);
		contextualUndoAdapter.setListView(getListView());
		getListView().setAdapter(contextualUndoAdapter);
		contextualUndoAdapter.setDeleteItemCallback(new MyDeleteItemCallback());
	}

	private class MyDeleteItemCallback implements ContextualUndoAdapter.DeleteItemCallback {

		@Override
		public void deleteItem(int position) {
			mAdapter.remove(position);
			mAdapter.notifyDataSetChanged();
		}
	}
}