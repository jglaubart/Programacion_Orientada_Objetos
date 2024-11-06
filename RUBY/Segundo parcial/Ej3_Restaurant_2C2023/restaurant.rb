# frozen_string_literal: true
require 'set/sorted_set'
require_relative 'table'
class Restaurant

  def initialize(name)
    @name = name
    @tables_per_section = {}
  end

  def add_table(section, name, cap)
    @tables_per_section[section] = SortedSet.new unless @tables_per_section.key?(section)
    @tables_per_section[section] << Table.new(name, cap, section)
  end

  def tables(section)
    check_section(section)
    @tables_per_section[section]
  end

  def sections_count
    @tables_per_section.size
  end

  def tables_count(section)
    check_section(section)
    @tables_per_section[section].size
  end

  private
  def check_section(section)
    raise ArgumentError, 'Section does not exists' unless @tables_per_section.key?(section)
  end
end
