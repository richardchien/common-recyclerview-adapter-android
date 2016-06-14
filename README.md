# Common RecyclerView Adapter for Android

[![License](https://img.shields.io/github/license/mashape/apistatus.svg?maxAge=2592000)]()
[![Release](https://jitpack.io/v/richardchien/common-recyclerview-adapter-android.svg)](https://jitpack.io/#richardchien/common-recyclerview-adapter-android)

A reusable RecyclerView.Adapter.

## Usage

Add the following to your module's `build.gradle`:

```groovy
allprojects {
    repositories {
        maven { url "https://jitpack.io" }
    }
}

dependencies {
    compile 'com.github.richardchien:common-recyclerview-adapter-android:v1.0.0'
}
```

Then use it:

```java
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
```

## Reference

- [明日之星-RecyclerView](http://www.imooc.com/learn/424)
