package com.example.prac02;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import java.util.ArrayList;
import java.util.List;

public class StaffViewModel extends ViewModel {

    private final MutableLiveData<List<Staff>> staffListLiveData = new MutableLiveData<>();

    public StaffViewModel() {
        staffListLiveData.setValue(new ArrayList<>());
    }

    public LiveData<List<Staff>> getStaffListLiveData() {
        return staffListLiveData;
    }

    public void addStaff(Staff staff) {
        List<Staff> currentList = staffListLiveData.getValue();
        if (currentList != null) {
            currentList.add(staff);
            staffListLiveData.setValue(currentList);
        }
    }
}
