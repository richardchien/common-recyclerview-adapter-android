package im.r_c.android.commonrecyclerviewadapter.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import im.r_c.android.commonrecyclerviewadapter.CommonRecyclerViewAdapter;
import im.r_c.android.commonrecyclerviewadapter.ViewHolder;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private List<Bean> mDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDataList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            mDataList.add(new Bean("Title " + (i + 1), "This is description " + (i + 1), R.mipmap.ic_launcher));
        }

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        CommonRecyclerViewAdapter<Bean> adapter = new CommonRecyclerViewAdapter<Bean>(this, mDataList, R.layout.list_item) {
            @Override
            public void onPostBindViewHolder(ViewHolder holder, Bean bean) {
                holder.setViewText(R.id.tv_title, bean.getTitle())
                        .setViewText(R.id.tv_desc, bean.getDescription())
                        .setViewProperty(R.id.tv_desc, "text", bean.getDescription() + " Changed")
                        .setViewImageResource(R.id.iv_image, bean.getImageResId());
            }
        };
        adapter.setOnItemClickListener(new CommonRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MainActivity.this, "Clicked " + (position + 1), Toast.LENGTH_SHORT).show();
            }
        });
        mRecyclerView.setAdapter(adapter);
    }

    class Bean {
        private String title;
        private String description;
        private int imageResId;

        public Bean(String title, String description, int imageResId) {
            this.title = title;
            this.description = description;
            this.imageResId = imageResId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getImageResId() {
            return imageResId;
        }

        public void setImageResId(int imageResId) {
            this.imageResId = imageResId;
        }
    }
}
