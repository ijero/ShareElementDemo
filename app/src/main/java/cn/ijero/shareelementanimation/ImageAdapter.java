package cn.ijero.shareelementanimation;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by Administrator on 2017/3/17.
 */

class ImageAdapter extends RecyclerView.Adapter {
    private List<ImageBean.ImgsBean> imgs = new ArrayList<>();
    private OnItemClickListener onItemClickListener;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder) {
            ViewHolder viewHolder = (ViewHolder) holder;
            ImageView imgView = viewHolder.imgView;
            int adapterPosition = viewHolder.getAdapterPosition();
            String imageUrl = imgs.get(adapterPosition).getImageUrl();
            Glide.with(imgView.getContext()).load(imageUrl).into(imgView);
        }
    }

    @Override
    public int getItemCount() {
        return imgs == null ? 0 : imgs.size();
    }

    public void addImgs(List<ImageBean.ImgsBean> imgs) {
        this.imgs.addAll(imgs);
        notifyDataSetChanged();
    }


    public interface OnItemClickListener {
        void onClickItem(View view, int position, ImageBean.ImgsBean imgsBean);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    private class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imgView;

        ViewHolder(View itemView) {
            super(itemView);

            imgView = (ImageView) itemView.findViewById(R.id.iv_item_image);
            imgView.setTransitionName(Contract.SHARED_IMAGE_ELEMENT_NAME);
            imgView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (onItemClickListener == null) {
                return;
            }
            int position = getAdapterPosition();
            onItemClickListener.onClickItem(v, position, imgs.get(position));
        }
    }
}
