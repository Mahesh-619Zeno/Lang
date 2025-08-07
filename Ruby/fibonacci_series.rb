puts "Enter number of terms:"
n = gets.to_i
a, b = 0, 1

puts "Fibonacci Series:"
n.times do
  print "#{a} "
  a, b = b, a + b
end
