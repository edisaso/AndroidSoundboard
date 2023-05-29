package com.example.soundboard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SoundAdapter extends RecyclerView.Adapter<SoundAdapter.SoundViewHolder> {

    private List<Sound> soundList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public SoundAdapter(List<Sound> soundList, OnItemClickListener listener) {
        this.soundList = soundList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public SoundViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sound, parent, false);
        return new SoundViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SoundViewHolder holder, int position) {
        Sound sound = soundList.get(position);
        holder.bind(sound);
    }

    @Override
    public int getItemCount() {
        return soundList.size();
    }

    class SoundViewHolder extends RecyclerView.ViewHolder {
        private Button soundButton;

        SoundViewHolder(@NonNull View itemView) {
            super(itemView);
            soundButton = itemView.findViewById(R.id.soundButton);
        }

        void bind(Sound sound) {
            soundButton.setText(sound.getName());
            soundButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(position);
                    }
                }
            });
        }
    }
}
