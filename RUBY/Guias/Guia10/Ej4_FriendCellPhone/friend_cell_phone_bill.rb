# frozen_string_literal: true
require_relative 'cell_phone_bill'
class FriendCellPhoneBill < CellPhoneBill

  def initialize(number, limit)
    super(number)
    @limit = limit
    @friends = []
    @@cost_friends_per_second = 0
  end

  def self.change_cost(cost)
    @@cost_friends_per_second = cost
  end

  def add_friend(number)
    raise 'Friend already exists' if @friends.include?(number)
    raise 'Too many friends' if @friends.length >= @limit
    @friends.push(number)
  end

  def remove_friend(number)
    raise 'Friend does not exist' unless @friends.include?(number)
    @friends.delete(number)
  end

  def process_bill
    @calls.map{ |c| @friends.include?(c.to) ? c.cost * @@cost_friends_per_second : c.cost }.reduce(0, :+)
  end
end
