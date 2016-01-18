Common RecyclerView Adapter for Android
=========

A reusable RecyclerView.Adapter.

###Usage

```java
mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
CommonRecyclerViewAdapter<Bean> adapter = new CommonRecyclerViewAdapter<Bean>(this, mDataList, R.layout.list_item) {
    @Override
    public void onItemViewAppear(ViewHolder holder, Bean bean) {
        holder.setViewText(R.id.tv_title, bean.getTitle())
                .setViewText(R.id.tv_desc, bean.getDescription())
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

###Reference

[明日之星-RecyclerView](http://www.imooc.com/learn/424)

###License

>The MIT License (MIT)
>
>Copyright (c) 2015 Richard Chien
>
>Permission is hereby granted, free of charge, to any person obtaining a copy
>of this software and associated documentation files (the "Software"), to deal
>in the Software without restriction, including without limitation the rights
>to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
>copies of the Software, and to permit persons to whom the Software is
>furnished to do so, subject to the following conditions:
>
>The above copyright notice and this permission notice shall be included in
>all copies or substantial portions of the Software.
>
>THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
>IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
>FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
>AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
>LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
>OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
>THE SOFTWARE.
