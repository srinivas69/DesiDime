package com.seenu.desidime;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.koushikdutta.urlimageviewhelper.UrlImageViewHelper;

import android.content.Context;
import android.text.Html;
import android.text.InputFilter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class DealsListAdapter extends BaseAdapter {
	private Context context;
	private DealsObject obj;

	public DealsListAdapter(Context context, DealsObject obj) {
		// TODO Auto-generated constructor stub
		this.context = context;
		this.obj = obj;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return obj.getResult().getTop().size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return obj.getResult().getTop().get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		// TODO Auto-generated method stub

		ViewHolder holder = null;

		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		if (view == null) {
			view = inflater.inflate(R.layout.deals_lv_items, null);
			holder = new ViewHolder();

			holder.imageViewAdpIv = (ImageView) view
					.findViewById(R.id.imageView1);
			holder.titleAdpTv = (TextView) view.findViewById(R.id.textView1);
			holder.descAdpTv = (TextView) view.findViewById(R.id.textView2);
			view.setTag(holder);
		} else
			holder = (ViewHolder) view.getTag();

		String title = obj.getResult().getTop().get(position).getTitle();
		String imageUrl = obj.getResult().getTop().get(position).getPic_thumb();
		String des = obj.getResult().getTop().get(position).getDeal_detail();

		// parsing deal detail with jsoup library
		Document document = Jsoup.parse(des);
		String pEleDes = document.select("p").first().text();

		int pEleDesLen = pEleDes.length();

		holder.titleAdpTv.setText(title);

		if (pEleDesLen > 50) {

			String desSubStr = pEleDes.substring(0, 50);

			holder.descAdpTv.setText(desSubStr + "...."
					+ Html.fromHtml("<b>" + "How to get this deal" + "</b>"));
		} else {
			holder.descAdpTv.setText(pEleDes + "...."
					+ Html.fromHtml("<b>" + "How to get this deal" + "</b>"));
		}

		if (imageUrl != null) {

			UrlImageViewHelper.setUrlDrawable(holder.imageViewAdpIv, imageUrl,
					R.drawable.ic_launcher);

		} else
			UrlImageViewHelper.setUrlDrawable(holder.imageViewAdpIv, null,
					R.drawable.ic_launcher);
		return view;
	}

	private static class ViewHolder {

		private ImageView imageViewAdpIv;
		private TextView titleAdpTv;
		private TextView descAdpTv;
	}

}
