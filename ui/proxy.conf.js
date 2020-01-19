const PROXY_CONFIG = [
  {
    context: [
      '/camp',
      '/arena',
      '/promoter'
    ],
    target: 'http://localhost:8080',
    secure: false
  }
];

module.exports = PROXY_CONFIG;
