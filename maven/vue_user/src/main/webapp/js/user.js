new Vue({
    el: "#app",
    data: {
        userList: [],
        user:{}
    },
    methods: {
        onClick: function () {
            //使用axios进行数据访问
            axios.get("/vuejsDemo/user/1.do")
                .then(function (response) {
                    console.log(response.data);
                })
        },
        getUserAll: function () {
            _this = this;
            //使用axios进行数据访问
            axios.get("/vuejsDemo/user/all.do")
                .then(function (response) {
                    _this.userList = response.data;
                })
        },
        getUserInfo:function (id) {
            _this = this;
            axios.get("/vuejsDemo/user/"+id+".do")
                .then(function (response) {
                    _this.user = response.data;
                    $("#myModal").modal("show");
                })
        },
        updateUser: function () {
            _this = this;
            axios.post("/vuejsDemo/user/update.do",_this.user)
                .then(function (response) {
                    var result = response.data.result;
                    if("OK" == result) {
                        alert("修改成功");
                    }
                })
        }
    },
    created:function () {
        this.getUserAll();
    }
})