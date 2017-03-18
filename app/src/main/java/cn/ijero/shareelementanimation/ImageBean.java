package cn.ijero.shareelementanimation;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/3/17.
 */

public class ImageBean implements Serializable {

    private String col;
    private String tag;
    private String tag3;
    private String sort;
    private int totalNum;
    private int startIndex;
    private int returnNumber;
    private List<ImgsBean> imgs;

    public String getCol() {
        return col;
    }

    public void setCol(String col) {
        this.col = col;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTag3() {
        return tag3;
    }

    public void setTag3(String tag3) {
        this.tag3 = tag3;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getReturnNumber() {
        return returnNumber;
    }

    public void setReturnNumber(int returnNumber) {
        this.returnNumber = returnNumber;
    }

    public List<ImgsBean> getImgs() {
        return imgs;
    }

    public void setImgs(List<ImgsBean> imgs) {
        this.imgs = imgs;
    }

    public static class ImgsBean implements Serializable {
        /**
         * id : 11684592185
         * desc : 来自岛国的小清新妹子们
         * tags : ["小清新"]
         * owner : {"userName":"greenideas","userId":"62593895","userSign":"452984832 62859743","isSelf":"0","portrait":"671b677265656e6964656173bb03","isVip":"0","isLanv":"0","isJiaju":"","isHunjia":"","orgName":"","resUrl":"","cert":"","budgetNum":"","lanvName":"","contactName":""}
         * fromPageTitle : 来自岛国的小清新妹子们
         * column : 美女
         * parentTag :
         * date : 2016-10-25
         * downloadUrl : http://b.hiphotos.baidu.com/image/pic/item/18d8bc3eb13533fabb31d2a6aad3fd1f40345bb6.jpg
         * imageUrl : http://b.hiphotos.baidu.com/image/pic/item/18d8bc3eb13533fabb31d2a6aad3fd1f40345bb6.jpg
         * imageWidth : 580
         * imageHeight : 743
         * thumbnailUrl : http://imgt9.bdstatic.com/it/u=2,3094657593&fm=25&gp=0.jpg
         * thumbnailWidth : 230
         * thumbnailHeight : 294
         * thumbLargeWidth : 310
         * thumbLargeHeight : 397
         * thumbLargeUrl : http://b.hiphotos.baidu.com/image/w%3D310/sign=1694cd8099504fc2a25fb604d5dce7f0/18d8bc3eb13533fabb31d2a6aad3fd1f40345bb6.jpg
         * thumbLargeTnWidth : 400
         * thumbLargeTnHeight : 512
         * thumbLargeTnUrl : http://b.hiphotos.baidu.com/image/w%3D400/sign=8082efe84dc2d562f208d1edd71090f3/18d8bc3eb13533fabb31d2a6aad3fd1f40345bb6.jpg
         * siteName :
         * siteLogo :
         * siteUrl :
         * fromUrl : http://www.iyi8.com/2013/mm_1030/1402_10.html
         * isBook : 0
         * bookId : 0
         * objUrl : http://www.iyi8.com/uploadfile/2014/0422/20140422123756205.jpg
         * shareUrl : http://b.hiphotos.baidu.com/image/s%3D550%3Bc%3Dwantu%2C8%2C95/sign=f0ad0b866509c93d03f20ef2af069be1/18d8bc3eb13533fabb31d2a6aad3fd1f40345bb6.jpg?referer=eba17a4c19d5ad6ef3ee50daa56c
         * setId : -1
         * albumId : 401461596
         * isAlbum : 0
         * albumName :
         * albumNum : 1
         * userId : 62593895
         * isVip : 0
         * isDapei : 0
         * dressId :
         * dressBuyLink :
         * dressPrice : 0
         * dressDiscount : 0
         * dressExtInfo :
         * dressTag :
         * dressNum : 0
         * objTag : 小清新
         * dressImgNum : 0
         * hostName : www.iyi8.com
         * pictureId : 11684592185
         * pictureSign : 40e9047bfa259c63e5a7bef834e15700b4daa9ba
         * dataSrc :
         * contentSign : 2866367027,78094335
         * albumDi :
         * canAlbumId :
         * albumObjNum :
         * appId :
         * photoId :
         * fromName : 0
         * fashion : null
         * title : 来自岛国的小清新妹子们
         */

        private String id;
        private String desc;
        private OwnerBean owner;
        private String fromPageTitle;
        private String column;
        private String parentTag;
        private String date;
        private String downloadUrl;
        private String imageUrl;
        private int imageWidth;
        private int imageHeight;
        private String thumbnailUrl;
        private int thumbnailWidth;
        private int thumbnailHeight;
        private int thumbLargeWidth;
        private int thumbLargeHeight;
        private String thumbLargeUrl;
        private int thumbLargeTnWidth;
        private int thumbLargeTnHeight;
        private String thumbLargeTnUrl;
        private String siteName;
        private String siteLogo;
        private String siteUrl;
        private String fromUrl;
        private String isBook;
        private String bookId;
        private String objUrl;
        private String shareUrl;
        private String setId;
        private String albumId;
        private int isAlbum;
        private String albumName;
        private int albumNum;
        private String userId;
        private int isVip;
        private int isDapei;
        private String dressId;
        private String dressBuyLink;
        private int dressPrice;
        private int dressDiscount;
        private String dressExtInfo;
        private String dressTag;
        private int dressNum;
        private String objTag;
        private int dressImgNum;
        private String hostName;
        private String pictureId;
        private String pictureSign;
        private String dataSrc;
        private String contentSign;
        private String albumDi;
        private String canAlbumId;
        private String albumObjNum;
        private String appId;
        private String photoId;
        private int fromName;
        private String fashion;
        private String title;
        private List<String> tags;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public OwnerBean getOwner() {
            return owner;
        }

        public void setOwner(OwnerBean owner) {
            this.owner = owner;
        }

        public String getFromPageTitle() {
            return fromPageTitle;
        }

        public void setFromPageTitle(String fromPageTitle) {
            this.fromPageTitle = fromPageTitle;
        }

        public String getColumn() {
            return column;
        }

        public void setColumn(String column) {
            this.column = column;
        }

        public String getParentTag() {
            return parentTag;
        }

        public void setParentTag(String parentTag) {
            this.parentTag = parentTag;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getDownloadUrl() {
            return downloadUrl;
        }

        public void setDownloadUrl(String downloadUrl) {
            this.downloadUrl = downloadUrl;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public int getImageWidth() {
            return imageWidth;
        }

        public void setImageWidth(int imageWidth) {
            this.imageWidth = imageWidth;
        }

        public int getImageHeight() {
            return imageHeight;
        }

        public void setImageHeight(int imageHeight) {
            this.imageHeight = imageHeight;
        }

        public String getThumbnailUrl() {
            return thumbnailUrl;
        }

        public void setThumbnailUrl(String thumbnailUrl) {
            this.thumbnailUrl = thumbnailUrl;
        }

        public int getThumbnailWidth() {
            return thumbnailWidth;
        }

        public void setThumbnailWidth(int thumbnailWidth) {
            this.thumbnailWidth = thumbnailWidth;
        }

        public int getThumbnailHeight() {
            return thumbnailHeight;
        }

        public void setThumbnailHeight(int thumbnailHeight) {
            this.thumbnailHeight = thumbnailHeight;
        }

        public int getThumbLargeWidth() {
            return thumbLargeWidth;
        }

        public void setThumbLargeWidth(int thumbLargeWidth) {
            this.thumbLargeWidth = thumbLargeWidth;
        }

        public int getThumbLargeHeight() {
            return thumbLargeHeight;
        }

        public void setThumbLargeHeight(int thumbLargeHeight) {
            this.thumbLargeHeight = thumbLargeHeight;
        }

        public String getThumbLargeUrl() {
            return thumbLargeUrl;
        }

        public void setThumbLargeUrl(String thumbLargeUrl) {
            this.thumbLargeUrl = thumbLargeUrl;
        }

        public int getThumbLargeTnWidth() {
            return thumbLargeTnWidth;
        }

        public void setThumbLargeTnWidth(int thumbLargeTnWidth) {
            this.thumbLargeTnWidth = thumbLargeTnWidth;
        }

        public int getThumbLargeTnHeight() {
            return thumbLargeTnHeight;
        }

        public void setThumbLargeTnHeight(int thumbLargeTnHeight) {
            this.thumbLargeTnHeight = thumbLargeTnHeight;
        }

        public String getThumbLargeTnUrl() {
            return thumbLargeTnUrl;
        }

        public void setThumbLargeTnUrl(String thumbLargeTnUrl) {
            this.thumbLargeTnUrl = thumbLargeTnUrl;
        }

        public String getSiteName() {
            return siteName;
        }

        public void setSiteName(String siteName) {
            this.siteName = siteName;
        }

        public String getSiteLogo() {
            return siteLogo;
        }

        public void setSiteLogo(String siteLogo) {
            this.siteLogo = siteLogo;
        }

        public String getSiteUrl() {
            return siteUrl;
        }

        public void setSiteUrl(String siteUrl) {
            this.siteUrl = siteUrl;
        }

        public String getFromUrl() {
            return fromUrl;
        }

        public void setFromUrl(String fromUrl) {
            this.fromUrl = fromUrl;
        }

        public String getIsBook() {
            return isBook;
        }

        public void setIsBook(String isBook) {
            this.isBook = isBook;
        }

        public String getBookId() {
            return bookId;
        }

        public void setBookId(String bookId) {
            this.bookId = bookId;
        }

        public String getObjUrl() {
            return objUrl;
        }

        public void setObjUrl(String objUrl) {
            this.objUrl = objUrl;
        }

        public String getShareUrl() {
            return shareUrl;
        }

        public void setShareUrl(String shareUrl) {
            this.shareUrl = shareUrl;
        }

        public String getSetId() {
            return setId;
        }

        public void setSetId(String setId) {
            this.setId = setId;
        }

        public String getAlbumId() {
            return albumId;
        }

        public void setAlbumId(String albumId) {
            this.albumId = albumId;
        }

        public int getIsAlbum() {
            return isAlbum;
        }

        public void setIsAlbum(int isAlbum) {
            this.isAlbum = isAlbum;
        }

        public String getAlbumName() {
            return albumName;
        }

        public void setAlbumName(String albumName) {
            this.albumName = albumName;
        }

        public int getAlbumNum() {
            return albumNum;
        }

        public void setAlbumNum(int albumNum) {
            this.albumNum = albumNum;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public int getIsVip() {
            return isVip;
        }

        public void setIsVip(int isVip) {
            this.isVip = isVip;
        }

        public int getIsDapei() {
            return isDapei;
        }

        public void setIsDapei(int isDapei) {
            this.isDapei = isDapei;
        }

        public String getDressId() {
            return dressId;
        }

        public void setDressId(String dressId) {
            this.dressId = dressId;
        }

        public String getDressBuyLink() {
            return dressBuyLink;
        }

        public void setDressBuyLink(String dressBuyLink) {
            this.dressBuyLink = dressBuyLink;
        }

        public int getDressPrice() {
            return dressPrice;
        }

        public void setDressPrice(int dressPrice) {
            this.dressPrice = dressPrice;
        }

        public int getDressDiscount() {
            return dressDiscount;
        }

        public void setDressDiscount(int dressDiscount) {
            this.dressDiscount = dressDiscount;
        }

        public String getDressExtInfo() {
            return dressExtInfo;
        }

        public void setDressExtInfo(String dressExtInfo) {
            this.dressExtInfo = dressExtInfo;
        }

        public String getDressTag() {
            return dressTag;
        }

        public void setDressTag(String dressTag) {
            this.dressTag = dressTag;
        }

        public int getDressNum() {
            return dressNum;
        }

        public void setDressNum(int dressNum) {
            this.dressNum = dressNum;
        }

        public String getObjTag() {
            return objTag;
        }

        public void setObjTag(String objTag) {
            this.objTag = objTag;
        }

        public int getDressImgNum() {
            return dressImgNum;
        }

        public void setDressImgNum(int dressImgNum) {
            this.dressImgNum = dressImgNum;
        }

        public String getHostName() {
            return hostName;
        }

        public void setHostName(String hostName) {
            this.hostName = hostName;
        }

        public String getPictureId() {
            return pictureId;
        }

        public void setPictureId(String pictureId) {
            this.pictureId = pictureId;
        }

        public String getPictureSign() {
            return pictureSign;
        }

        public void setPictureSign(String pictureSign) {
            this.pictureSign = pictureSign;
        }

        public String getDataSrc() {
            return dataSrc;
        }

        public void setDataSrc(String dataSrc) {
            this.dataSrc = dataSrc;
        }

        public String getContentSign() {
            return contentSign;
        }

        public void setContentSign(String contentSign) {
            this.contentSign = contentSign;
        }

        public String getAlbumDi() {
            return albumDi;
        }

        public void setAlbumDi(String albumDi) {
            this.albumDi = albumDi;
        }

        public String getCanAlbumId() {
            return canAlbumId;
        }

        public void setCanAlbumId(String canAlbumId) {
            this.canAlbumId = canAlbumId;
        }

        public String getAlbumObjNum() {
            return albumObjNum;
        }

        public void setAlbumObjNum(String albumObjNum) {
            this.albumObjNum = albumObjNum;
        }

        public String getAppId() {
            return appId;
        }

        public void setAppId(String appId) {
            this.appId = appId;
        }

        public String getPhotoId() {
            return photoId;
        }

        public void setPhotoId(String photoId) {
            this.photoId = photoId;
        }

        public int getFromName() {
            return fromName;
        }

        public void setFromName(int fromName) {
            this.fromName = fromName;
        }

        public String getFashion() {
            return fashion;
        }

        public void setFashion(String fashion) {
            this.fashion = fashion;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<String> getTags() {
            return tags;
        }

        public void setTags(List<String> tags) {
            this.tags = tags;
        }

        public static class OwnerBean  implements Serializable {
            /**
             * userName : greenideas
             * userId : 62593895
             * userSign : 452984832 62859743
             * isSelf : 0
             * portrait : 671b677265656e6964656173bb03
             * isVip : 0
             * isLanv : 0
             * isJiaju :
             * isHunjia :
             * orgName :
             * resUrl :
             * cert :
             * budgetNum :
             * lanvName :
             * contactName :
             */

            private String userName;
            private String userId;
            private String userSign;
            private String isSelf;
            private String portrait;
            private String isVip;
            private String isLanv;
            private String isJiaju;
            private String isHunjia;
            private String orgName;
            private String resUrl;
            private String cert;
            private String budgetNum;
            private String lanvName;
            private String contactName;

            public String getUserName() {
                return userName;
            }

            public void setUserName(String userName) {
                this.userName = userName;
            }

            public String getUserId() {
                return userId;
            }

            public void setUserId(String userId) {
                this.userId = userId;
            }

            public String getUserSign() {
                return userSign;
            }

            public void setUserSign(String userSign) {
                this.userSign = userSign;
            }

            public String getIsSelf() {
                return isSelf;
            }

            public void setIsSelf(String isSelf) {
                this.isSelf = isSelf;
            }

            public String getPortrait() {
                return portrait;
            }

            public void setPortrait(String portrait) {
                this.portrait = portrait;
            }

            public String getIsVip() {
                return isVip;
            }

            public void setIsVip(String isVip) {
                this.isVip = isVip;
            }

            public String getIsLanv() {
                return isLanv;
            }

            public void setIsLanv(String isLanv) {
                this.isLanv = isLanv;
            }

            public String getIsJiaju() {
                return isJiaju;
            }

            public void setIsJiaju(String isJiaju) {
                this.isJiaju = isJiaju;
            }

            public String getIsHunjia() {
                return isHunjia;
            }

            public void setIsHunjia(String isHunjia) {
                this.isHunjia = isHunjia;
            }

            public String getOrgName() {
                return orgName;
            }

            public void setOrgName(String orgName) {
                this.orgName = orgName;
            }

            public String getResUrl() {
                return resUrl;
            }

            public void setResUrl(String resUrl) {
                this.resUrl = resUrl;
            }

            public String getCert() {
                return cert;
            }

            public void setCert(String cert) {
                this.cert = cert;
            }

            public String getBudgetNum() {
                return budgetNum;
            }

            public void setBudgetNum(String budgetNum) {
                this.budgetNum = budgetNum;
            }

            public String getLanvName() {
                return lanvName;
            }

            public void setLanvName(String lanvName) {
                this.lanvName = lanvName;
            }

            public String getContactName() {
                return contactName;
            }

            public void setContactName(String contactName) {
                this.contactName = contactName;
            }

            @Override
            public String toString() {
                return "OwnerBean{" +
                        "userName='" + userName + '\'' +
                        ", userId='" + userId + '\'' +
                        ", userSign='" + userSign + '\'' +
                        ", isSelf='" + isSelf + '\'' +
                        ", portrait='" + portrait + '\'' +
                        ", isVip='" + isVip + '\'' +
                        ", isLanv='" + isLanv + '\'' +
                        ", isJiaju='" + isJiaju + '\'' +
                        ", isHunjia='" + isHunjia + '\'' +
                        ", orgName='" + orgName + '\'' +
                        ", resUrl='" + resUrl + '\'' +
                        ", cert='" + cert + '\'' +
                        ", budgetNum='" + budgetNum + '\'' +
                        ", lanvName='" + lanvName + '\'' +
                        ", contactName='" + contactName + '\'' +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "ImgsBean{" +
                    "id='" + id + '\'' +
                    ", desc='" + desc + '\'' +
                    ", owner=" + owner +
                    ", fromPageTitle='" + fromPageTitle + '\'' +
                    ", column='" + column + '\'' +
                    ", parentTag='" + parentTag + '\'' +
                    ", date='" + date + '\'' +
                    ", downloadUrl='" + downloadUrl + '\'' +
                    ", imageUrl='" + imageUrl + '\'' +
                    ", imageWidth=" + imageWidth +
                    ", imageHeight=" + imageHeight +
                    ", thumbnailUrl='" + thumbnailUrl + '\'' +
                    ", thumbnailWidth=" + thumbnailWidth +
                    ", thumbnailHeight=" + thumbnailHeight +
                    ", thumbLargeWidth=" + thumbLargeWidth +
                    ", thumbLargeHeight=" + thumbLargeHeight +
                    ", thumbLargeUrl='" + thumbLargeUrl + '\'' +
                    ", thumbLargeTnWidth=" + thumbLargeTnWidth +
                    ", thumbLargeTnHeight=" + thumbLargeTnHeight +
                    ", thumbLargeTnUrl='" + thumbLargeTnUrl + '\'' +
                    ", siteName='" + siteName + '\'' +
                    ", siteLogo='" + siteLogo + '\'' +
                    ", siteUrl='" + siteUrl + '\'' +
                    ", fromUrl='" + fromUrl + '\'' +
                    ", isBook='" + isBook + '\'' +
                    ", bookId='" + bookId + '\'' +
                    ", objUrl='" + objUrl + '\'' +
                    ", shareUrl='" + shareUrl + '\'' +
                    ", setId='" + setId + '\'' +
                    ", albumId='" + albumId + '\'' +
                    ", isAlbum=" + isAlbum +
                    ", albumName='" + albumName + '\'' +
                    ", albumNum=" + albumNum +
                    ", userId='" + userId + '\'' +
                    ", isVip=" + isVip +
                    ", isDapei=" + isDapei +
                    ", dressId='" + dressId + '\'' +
                    ", dressBuyLink='" + dressBuyLink + '\'' +
                    ", dressPrice=" + dressPrice +
                    ", dressDiscount=" + dressDiscount +
                    ", dressExtInfo='" + dressExtInfo + '\'' +
                    ", dressTag='" + dressTag + '\'' +
                    ", dressNum=" + dressNum +
                    ", objTag='" + objTag + '\'' +
                    ", dressImgNum=" + dressImgNum +
                    ", hostName='" + hostName + '\'' +
                    ", pictureId='" + pictureId + '\'' +
                    ", pictureSign='" + pictureSign + '\'' +
                    ", dataSrc='" + dataSrc + '\'' +
                    ", contentSign='" + contentSign + '\'' +
                    ", albumDi='" + albumDi + '\'' +
                    ", canAlbumId='" + canAlbumId + '\'' +
                    ", albumObjNum='" + albumObjNum + '\'' +
                    ", appId='" + appId + '\'' +
                    ", photoId='" + photoId + '\'' +
                    ", fromName=" + fromName +
                    ", fashion='" + fashion + '\'' +
                    ", title='" + title + '\'' +
                    ", tags=" + tags +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "ImageBean{" +
                "col='" + col + '\'' +
                ", tag='" + tag + '\'' +
                ", tag3='" + tag3 + '\'' +
                ", sort='" + sort + '\'' +
                ", totalNum=" + totalNum +
                ", startIndex=" + startIndex +
                ", returnNumber=" + returnNumber +
                ", imgs=" + imgs +
                '}';
    }
}
