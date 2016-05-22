package com.panzhiming.play.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;

public abstract class BaseAdapter<T> extends android.widget.BaseAdapter {
	private Context context;
	private List<T> list;
	private LayoutInflater inflater;
	
	public BaseAdapter(Context context, List<T> list){
		setContext(context);
		setList(list);
		setInflater(context);
	}
	

	public final Context getContext() {
		return context;
	}

	public final void setContext(Context context) {
		this.context = context;
	}

	public final List<T> getList() {
		return list;
	}

	public final void setList(List<T> list) {
		this.list = list;
	}

	public final LayoutInflater getInflater() {
		return inflater;
	}

	private final void setInflater(Context context) {
		inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	 
}
