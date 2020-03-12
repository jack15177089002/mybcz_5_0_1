package com.baicizhan.client.business.dataset.models;

import java.util.List;

public class BookCategory {
    private String category_name;
    private List<SubCategory> sub_categories;

    public class SubCategory {
        private List<Integer> book_ids;
        private String sub_name;

        public String getSubName() {
            return this.sub_name;
        }

        public void setSubName(String str) {
            this.sub_name = str;
        }

        public List<Integer> getBookIds() {
            return this.book_ids;
        }

        public void setBookIds(List<Integer> list) {
            this.book_ids = list;
        }
    }

    public String getCategoryName() {
        return this.category_name;
    }

    public void setCategoryName(String str) {
        this.category_name = str;
    }

    public int getSubCategorySize() {
        if (this.sub_categories == null) {
            return 0;
        }
        return this.sub_categories.size();
    }

    public List<SubCategory> getSubCategories() {
        return this.sub_categories;
    }

    public void setSubCategories(List<SubCategory> list) {
        this.sub_categories = list;
    }
}
