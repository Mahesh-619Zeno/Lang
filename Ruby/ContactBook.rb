require 'json'

class Contact
  attr_accessor :name, :phone, :email

  def initialize(name, phone, email)
    @name = name
    @phone = phone
    @email = email
  end

  def to_hash
    { name: @name, phone: @phone, email: @email }
  end

  def self.from_hash(hash)
    new(hash["name"], hash["phone"], hash["email"])
  end
end

class ContactBook
  FILE = "contacts.json"

  def initialize
    @contacts = load_contacts
  end

  def load_contacts
    if File.exist?(FILE)
      JSON.parse(File.read(FILE)).map { |c| Contact.from_hash(c) }
    else
      []
    end
  end

  def save_contacts
    File.write(FILE, JSON.pretty_generate(@contacts.map(&:to_hash)))
  end

  def add_contact
    print "Name: "; name = gets.chomp
    print "Phone: "; phone = gets.chomp
    print "Email: "; email = gets.chomp
    @contacts << Contact.new(name, phone, email)
    save_contacts
    puts "Contact added!"
  end

  def list_contacts
    puts "--- Contact List ---"
    @contacts.each_with_index do |c, i|
      puts "#{i+1}. #{c.name}, #{c.phone}, #{c.email}"
    end
  end

  def delete_contact
    list_contacts
    print "Enter number to delete: "
    index = gets.to_i - 1
    if index >= 0 && index < @contacts.size
      @contacts.delete_at(index)
      save_contacts
      puts "Deleted."
    else
      puts "Invalid index."
    end
  end

  def menu
    loop do
      puts "\n--- MENU ---\n1. Add Contact\n2. View Contacts\n3. Delete Contact\n4. Exit"
      print "Choice: "
      case gets.chomp
      when '1' then add_contact
      when '2' then list_contacts
      when '3' then delete_contact
      when '4' then break
      else puts "Invalid choice."
      end
    end
  end
end

ContactBook.new.menu
