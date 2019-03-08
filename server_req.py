from BaseHTTPServer import HTTPServer, BaseHTTPRequestHandler
from set_pin_up import open

class SimpleHTTPRequestHandler(BaseHTTPRequestHandler):

  def do_GET(self):
    self.send_response(200)
    self.end_headers()
    print self.path
    if self.path == '/hodor':
      open()
      self.wfile.write(b'Doors opened!')


httpd = HTTPServer(('', 80), SimpleHTTPRequestHandler)
httpd.serve_forever()
