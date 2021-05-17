import axios from '../request';

//注册接口
export const registerApi = (phone, pwd, name) =>
  axios.post('/api/v1/pri/user/register', {
    phone: phone,
    pwd: pwd,
    name: name,
  });
//登录接口
export const loginApi = (phone, pwd) =>
  axios.post('/api/v1/pri/user/login', {
    phone,
    pwd,
  });

//轮播图接口
export const getBanner = () => axios.get('/api/v1/pub/video/list_banner');

//视频列表接口
export const getVideoList = () => axios.get('/api/v1/pub/video/list');

// 视频详情接口
export const getVideoDetail = (vid) =>
  axios.get('/api/v1/pub/video/find_detail_by_id', {
    params: {
      video_id: vid,
    },
  });

// 用户信息接口
export const getUserInfo = (token) =>
  axios.get('/api/v1/pri/user/find_by_token', {
    params: {
      token,
    },
  });

// 订单列表接口
export const getOrderList = (token) =>
  axios.get('/api/v1/pri/order/list', {
    params: {
      token,
    },
  });

//下单接口
export const saveOrder = (token, vid) =>
  axios.post(
    '/api/v1/pri/order/save',
    {
      video_id: vid,
    },
    {
      headers: {
        token,
      },
    },
  );
