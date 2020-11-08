package com.example.form;

import java.util.List;
import java.sql.Timestamp;

/**
 * Класс повторяет сруктуру json запроса на сервер для добавления <b>новостей</b>, <b>мета-данных</b>, <b>блоков</b>.
 * @author Nikita Trifonov
 * @version 1.0
 */
public class AddFullNewsRequest {

    /**
     * Поле новости. Описывает элемент новости.
     * @see AddFullNewsRequest.NewsEntity
     */
    private NewsEntity news;

    /**
     * Поле мета-данных. Описывает элемент мета-данных.
     * @see AddFullNewsRequest.MetaDataEntity
     */
    private MetaDataEntity meta;

    /**
     * Коллекция блоков. Описывает коллекцию блоков новостей.
     * @see AddFullNewsRequest.BlocksEntity
     */
    private List<BlocksEntity> blocks;

    /**
     * Конструктор - создание нового объекта
     */
    public MetaDataEntity getMeta() {
        return meta;
    }

    public void setMeta(MetaDataEntity meta) {
        this.meta = meta;
    }

    public NewsEntity getNews() {
        return news;
    }

    public void setNews(NewsEntity news) {
        this.news = news;
    }

    public List<BlocksEntity> getBlocks() {
        return blocks;
    }

    public void setBlocks(List<BlocksEntity> blocks) {
        this.blocks = blocks;
    }

    /**
     * Функция переводит содержимое запроса в строку. НЕ ПАСИТ JSON
     */
    @Override
    public String toString() {
        return "AddFullNewsRequest{" +
                "meta=" + meta +
                ", news=" + news +
                ", blocks=" + blocks +
                '}';
    }

    /**
     * Класс описывает сущность <b>Новости</b>.
     * @author Nikita Trifonov
     * @version 1.1
     */
    public class NewsEntity {

        /** поле id новости генерируется автоматически на сервере */
        private long id;

        /** поле заголовка */
        private String title;

        /** поле подзаголовка */
        private String sub_title;

        /** поле id метаданных новости генерируется автоматически на сервере */
        private long meta_data;

        /** поле ссылки на картинку новости */
        private String image;

        /**
         * Конструктор - создание нового объекта
         */
        public NewsEntity() {
        }
    
        public long getId() {
            return id;
        }
    
        public String getTitle() {
            return title;
        }
    
        public String getSub_title() {
            return sub_title;
        }
    
        public long getMeta_data() {
            return meta_data;
        }
    
        public void setMeta_data(long meta_data) {
            this.meta_data = meta_data;
        }
    
        public String getImage() {
            return image;
        }
    
        public void setImage(String image) {
            this.image = image;
        }

        /**
         * Функция переводит содержимое объекта в строку. НЕ ПАСИТ JSON
         */
        @Override
        public String toString() {
            return "NewsEntity{" +
                    "id=" + id +
                    ", title='" + title + '\'' +
                    ", sub_title='" + sub_title + '\'' +
                    ", meta_data=" + meta_data +
                    '}';
        }
    }

    /**
     * Класс описывает сущность <b>Мета-данных</b>.
     * @author Nikita Trifonov
     * @version 1.0
     */
    public class MetaDataEntity {

        /** поле id мета-данных генерируется автоматически на сервере */
        private long id;

        /** поле временного штампа мета-данных генерируется автоматически на сервере */
        private Timestamp date;

        /** поле автора */
        private String creator;

        /** поле типа */
        private long type;

        /**
         * Конструктор - создание нового объекта
         */
        public MetaDataEntity() {
        }
    
        public long getId() {
            return id;
        }
    
        public Timestamp getDate() {
            return date;
        }
    
        public String getCreator() {
            return creator;
        }
    
        public long getType() {
            return type;
        }

        /**
         * Функция переводит содержимое объекта в строку. НЕ ПАСИТ JSON
         */
        @Override
        public String toString() {
            return "MetaDataEntity{" +
                    "id=" + id +
                    ", date=" + date +
                    ", creator='" + creator + '\'' +
                    ", type=" + type +
                    '}';
        }
    }

    /**
     * Класс описывает сущность <b>новостного блока</b>.
     * @author Nikita Trifonov
     * @version 1.1
     */
    public class BlocksEntity {

        /** поле id новостного блока генерируется автоматически на сервере */
        private long id;

        /** поле id новости новостного блока генерируется автоматически на сервере */
        private long news;

        /** номер сипа новости
         * 1 - text
         * 2 - image
         */
        private long type;

        /** позиция в общем представлении */
        private int position;

        /** Строковое значение блока зависит от {@link BlocksEntity#type}
         * Если {@link BlocksEntity#type} == 1 - вводится текст
         * Если {@link BlocksEntity#type} == 2 - вводится ссылка на картинку
         */
        private String data;

        /**
         * Конструктор - создание нового объекта
         */
        public BlocksEntity() {
        }

        public long getId() {
            return id;
        }

        public long getNews() {
            return news;
        }

        public long getType() {
            return type;
        }

        public int getPosition() {
            return position;
        }

        public String getData() {
            return data;
        }

        public void setNews(long news) {
            this.news = news;
        }

        public void setType(long type) {
            this.type = type;
        }

        public void setPosition(int position) {
            this.position = position;
        }

        public void setData(String data) {
            this.data = data;
        }

        /**
         * Функция переводит содержимое объекта в строку. НЕ ПАСИТ JSON
         */
        @Override
        public String toString() {
            return "BlocksEntity{" +
                    "id=" + id +
                    ", news=" + news +
                    ", type=" + type +
                    ", position=" + position +
                    ", data=" + data +
                    '}';
        }
    }
}
