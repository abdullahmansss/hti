package mans.firstapp.models;

import java.util.List;

public class PostsModel
{
    private boolean status;
    private int count;
    private int count_total;
    private int pages;
    private List<PostsDetails> posts;

    public PostsModel(boolean status, int count, int count_total, int pages, List<PostsDetails> posts)
    {
        this.status = status;
        this.count = count;
        this.count_total = count_total;
        this.pages = pages;
        this.posts = posts;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount_total() {
        return count_total;
    }

    public void setCount_total(int count_total) {
        this.count_total = count_total;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public List<PostsDetails> getPosts() {
        return posts;
    }

    public void setPosts(List<PostsDetails> posts) {
        this.posts = posts;
    }

    class PostsDetails
    {
        private int id;
        private String url;
        private String status;
        private String title;
        private String content;
        private String date;
        private List<Categories> categories;
        private List<Categories> tags;
        private Author author;

        public PostsDetails(int id, String url, String status, String title, String content, String date, List<Categories> categories, List<Categories> tags, Author author) {
            this.id = id;
            this.url = url;
            this.status = status;
            this.title = title;
            this.content = content;
            this.date = date;
            this.categories = categories;
            this.tags = tags;
            this.author = author;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public List<Categories> getCategories() {
            return categories;
        }

        public void setCategories(List<Categories> categories) {
            this.categories = categories;
        }

        public List<Categories> getTags() {
            return tags;
        }

        public void setTags(List<Categories> tags) {
            this.tags = tags;
        }

        public Author getAuthor() {
            return author;
        }

        public void setAuthor(Author author) {
            this.author = author;
        }
    }

    class Categories
    {
        private int id;
        private String name;

        public Categories(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    class Author
    {
        private int id;
        private String name;
        private String description;
        private String avatar;

        public Author(int id, String name, String description, String avatar) {
            this.id = id;
            this.name = name;
            this.description = description;
            this.avatar = avatar;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }
    }
}