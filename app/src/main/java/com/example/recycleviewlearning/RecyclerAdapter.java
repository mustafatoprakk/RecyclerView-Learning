package com.example.recycleviewlearning;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    ArrayList<String> courseName = new ArrayList<>();
    ArrayList<String> courseExplanation = new ArrayList<>();
    ArrayList<Integer> pictures = new ArrayList<>();

    Context context;

    public RecyclerAdapter(ArrayList<String> courseName, ArrayList<String> courseExplanation, ArrayList<Integer> pictures, Context context) {
        this.courseName = courseName;
        this.courseExplanation = courseExplanation;
        this.pictures = pictures;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_layout, parent, false);  // ** //
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.image.setImageResource(pictures.get(position));  // arraylist dizisindeki pictuture index numarasına göre alıyorum
        holder.courseName.setText(courseName.get(position));
        holder.courseExplanation.setText(courseExplanation.get(position));

        // Click
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Selected course " + courseName.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return courseName.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView image;
        TextView courseName, courseExplanation;
        LinearLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.circle_image);
            courseName = itemView.findViewById(R.id.txt_course_name);
            courseExplanation = itemView.findViewById(R.id.txt_course_explanation);
            parentLayout = itemView.findViewById(R.id.parent);
        }
    }
}
