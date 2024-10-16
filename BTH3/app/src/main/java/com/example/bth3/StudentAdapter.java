package com.example.bth3;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {
    private List<Student> studentList;
    private Context context;

    public StudentAdapter(List<Student> studentList, Context context) {
        this.studentList = studentList;
        this.context = context;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.student_item, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        Student student = studentList.get(position);

        holder.studentId.setText("ID: " + student.getId());

        String fullName = student.getFull_name().getFirst() + " " +
                student.getFull_name().getMidd() + " " +
                student.getFull_name().getLast();
        holder.studentName.setText(fullName);

        holder.studentGPA.setText(String.valueOf(student.getGpa()));

        if (student.getGender().equals("Nữ")) {
            holder.studentIcon.setImageResource(R.drawable.ic_woman);  // Icon nữ
        } else {
            holder.studentIcon.setImageResource(R.drawable.ic_man);    // Icon nam
        }

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, Student.class);
            intent.putExtra("student_id", student.getId());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public static class StudentViewHolder extends RecyclerView.ViewHolder {
        ImageView studentIcon;
        TextView studentId;
        TextView studentName;
        TextView studentGPA;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            studentIcon = itemView.findViewById(R.id.student_icon);
            studentId = itemView.findViewById(R.id.student_id);
            studentName = itemView.findViewById(R.id.student_name);
            studentGPA = itemView.findViewById(R.id.student_gpa);
        }
    }
}
