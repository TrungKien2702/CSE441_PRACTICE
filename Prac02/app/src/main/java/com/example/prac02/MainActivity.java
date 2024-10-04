package com.example.prac02;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {
    private StaffViewModel staffViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText edtId = findViewById(R.id.edtStaffId);
        EditText edtFullName = findViewById(R.id.edtStaffFullName);
        EditText edtBirthDate = findViewById(R.id.edtBirthDate);
        EditText edtSalary = findViewById(R.id.edtSalary);
        Button btnAddStaff = findViewById(R.id.btnAddStaff);
        TextView txtResult = findViewById(R.id.txtResult);
        TextView txtMessage = findViewById(R.id.txtMessage); // Thêm TextView cho thông báo

        // Lấy ViewModel
        staffViewModel = new ViewModelProvider(this).get(StaffViewModel.class);

        // Lắng nghe sự thay đổi của danh sách nhân viên
        staffViewModel.getStaffListLiveData().observe(this, staffList -> {
            if (staffList != null && !staffList.isEmpty()) {
                StringBuilder result = new StringBuilder();
                for (Staff staff : staffList) {
                    result.append(staff.toString()).append("\n");
                }
                txtResult.setText(result.toString());
                txtMessage.setText(""); // Reset thông báo khi có nhân viên
            } else {
                txtResult.setText("");
                txtMessage.setText("No Result!");
            }
        });

        // Xử lý sự kiện thêm nhân viên
        btnAddStaff.setOnClickListener(v -> {
            String id = edtId.getText().toString().trim();
            String fullName = edtFullName.getText().toString().trim();
            String birthDate = edtBirthDate.getText().toString().trim();
            String salary = edtSalary.getText().toString().trim();

            if (!id.isEmpty() && !fullName.isEmpty() && !birthDate.isEmpty() && !salary.isEmpty()) {
                // Thêm nhân viên mới vào ViewModel
                Staff newStaff = new Staff(id, fullName, birthDate, salary);
                staffViewModel.addStaff(newStaff);

                // Xóa nội dung nhập
                edtId.setText("");
                edtFullName.setText("");
                edtBirthDate.setText("");
                edtSalary.setText("");
                txtMessage.setText("Đã nhân nút thêm mới!"); // Hiển thị thông báo khi nhấn nút
            } else {
                txtMessage.setText("Chưa nhập dữ liệu!"); // Hiển thị thông báo nếu có trường để trống
            }
        });
    }
}
