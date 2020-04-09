package amin.learn.mvvm.project_1.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import amin.learn.mvvm.project_1.R;
import amin.learn.mvvm.project_1.databinding.ItemUserBinding;
import amin.learn.mvvm.project_1.viewmodel.UserViewModel;

public class UserAdaptor extends RecyclerView.Adapter<UserAdaptor.customHolder> {

    private ArrayList<UserViewModel> arrayList = new ArrayList<>();

    public UserAdaptor(ArrayList<UserViewModel> arrayList) {
        this.arrayList = arrayList;
    }

    private LayoutInflater layoutInflater;

    @NonNull
    @Override
    public customHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null)
            layoutInflater = LayoutInflater.from(parent.getContext());

        ItemUserBinding userBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_user,parent,false);

        return new customHolder(userBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull customHolder holder, int position) {
        UserViewModel userViewModel = arrayList.get(position);
        holder.bind(userViewModel);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class customHolder extends RecyclerView.ViewHolder{

        private ItemUserBinding itemUserBinding;

        public customHolder(@NonNull ItemUserBinding itemUserBinding) {
            super(itemUserBinding.getRoot());
            this.itemUserBinding = itemUserBinding;
        }

        private void bind(UserViewModel userViewModel){
            this.itemUserBinding.setItem(userViewModel);
            this.itemUserBinding.executePendingBindings();
        }

        public ItemUserBinding getItemUserBinding() {
            return itemUserBinding;
        }
    }


}
