export const environment = {
  production: true,
  API_URL: '/api',
  SOCKET_URL:(window.location.protocol === 'https:' ? 'wss:' : 'ws:') + '//' + window.location.host + '/socket'
};
